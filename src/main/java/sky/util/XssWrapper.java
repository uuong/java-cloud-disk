package sky.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Xss sql 注入过滤
 * User: krny
 * Date: 2017/2/26 0026
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
 */
public class XssWrapper extends HttpServletRequestWrapper {
    public XssWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);
        if (values == null) {
            return null;
        }
        int count = values.length;
        String[] encodeValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodeValues[i] = cleanXss(values[i]);
        }
        return encodeValues;
    }

    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        if (value == null) {
            return null;
        }
        return cleanXss(parameter);
    }

    private String cleanXss(String value) {
        value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        value = value.replaceAll("'", "&#39;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("script", "");
        //todo
        value = value.replaceAll(" ", "&nbsp;");
        return value;
    }
}
