package bvp.his.isofhcare.web.service;

import bvp.his.isofhcare.constant.AppConst;
import bvp.his.isofhcare.result.IException;
import bvp.his.isofhcare.result.IPaging;
import bvp.his.isofhcare.result.IResultError;
import bvp.his.isofhcare.result.IResultSuccess;
import bvp.his.isofhcare.utils.CustomException;
import bvp.his.isofhcare.utils.GsonUtils;
import bvp.his.isofhcare.utils.LogUtils;
import bvp.his.isofhcare.utils.StrUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class BaseService implements IResultError,IResultSuccess, IPaging, IException {


    public void init() {
        init(null);
    }

    /**
     * The time the service is called, used to calculate "service running time"
     */


    public void init(Object object) {
        log = LogUtils.getInstance();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        String url = request.getMethod() + " " + request.getRequestURI();
        String queryString = request.getQueryString();
        if (!StringUtils.isEmpty(queryString)) {
            url += "?" + queryString;
        }
        log.info(url);
        log.info("getRemoteAddr: " + request.getRemoteAddr());



        if (object != null) {
            String strObj = GsonUtils.toStringCompact(object);
            log.info(strObj);
//            jsonData = new JSONObject(GsonUtils.toString(object));
        }
    }

    /**
     * Log controller
     */
    protected LogUtils log;


    /**
     * Get Object with key in jsonData
     */
    public <U> U getObject(String key, Class<U> cls, JSONObject jsonData) {
        if (jsonData.has(key)) {
            return GsonUtils.toObject(jsonData.get(key).toString(), cls);
        }
        return null;
    }

    public JSONObject getJSONObject(String key, JSONObject jsonData) {
        if (jsonData.has(key)) {
            return jsonData.getJSONObject(key);
        }
        return null;
    }

    public JSONArray getJSONArray(String key, JSONObject jsonData) {
        if (jsonData.has(key)) {
            return jsonData.getJSONArray(key);
        }
        return null;
    }

    public JSONObject getJsonData(Object object){
        if(object!=null){
            return new JSONObject(GsonUtils.toString(object));
        }
        return null;
    }
    /**
     * Get param input as Integer
     */
    public Integer getInteger(String key, JSONObject jsonData) {
        if (jsonData.has(key)) {
            try {
                return jsonData.getInt(key);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Get param input as Integer
     */
    public Integer getInteger(String key, Integer defaultValue, JSONObject jsonData) {
        Integer value = getInteger(key,jsonData);
        return value != null ? value : defaultValue;
    }

    /**
     * Get param input as Long
     */
    public Long getLong(String key, JSONObject jsonData) {
        if (jsonData.has(key)) {
            try {
                return jsonData.getLong(key);
            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        }
        return null;
    }

    /**
     * Get param input as LocalDate
     */
    public LocalDate getDate(String key, JSONObject jsonData) {
        if (jsonData.has(key)) {
            String date = jsonData.getString(key);
            try {
                return LocalDate.parse(date, AppConst.DATE_FORMATTER);
            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        }
        return null;
    }

    /**
     * Get param input as LocalDate
     */
    public LocalDateTime getDateTime(String key, JSONObject jsonData) {
        if (jsonData.has(key)) {
            String date = jsonData.getString(key);
            try {
                return LocalDateTime.parse(date, AppConst.DATE_TIME_FORMATTER);
            }catch (Exception ex){
                log.error(ex.getMessage());
            }
        }
        return null;
    }

    public Long getLong(String key, Long defaultValue, JSONObject jsonData) {
        Long value = getLong(key,jsonData);
        return value != null ? value : defaultValue;
    }

    /**
     * Get param input as String, neu khong co properties nay thi tra ve null
     */
    public String getString(String key, JSONObject jsonData) {
        if (jsonData.has(key)) {
            return jsonData.getString(key);
        }
        return null;
    }

    public String getString(String key, String defaultValue, JSONObject jsonData) {
        if (jsonData.has("key")) {
            return jsonData.getString(key);
        }
        return defaultValue;
    }


    protected <T> T getEntityById(CrudRepository repository, Long id) {
        if (id == null || Objects.equals(0L, id)) return null;

        Optional entityOpt = repository.findById(id);
        if (!entityOpt.isPresent()) {
            return null;
        }
        return (T) entityOpt.get();
    }


    /**
     * format du lieu
     *
     * @param format
     * @param args
     * @return
     */
    protected String format(String format, Object... args) {
        return String.format(format, args);
    }

    /**
     * Tao text hien thi tren adress trinh duyet (linkAlias)
     *
     * @param text text muon chuyen thanh linkAlias
     * @return linkAlias
     */
    public String getTextUrl(String text) {
        return StrUtils.createUrlFromString(text);
    }

    CustomException getUnauthentication(String message) {
        return new CustomException(HttpServletResponse.SC_UNAUTHORIZED, message);
    }

    CustomException getUnauthentication() {
        return new CustomException(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Token ");
    }

}
