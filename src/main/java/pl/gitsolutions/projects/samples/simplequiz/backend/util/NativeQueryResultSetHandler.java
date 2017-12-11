//package pl.gitsolutions.projects.samples.simplequiz.backend.util;
//
//import com.google.gwt.thirdparty.guava.common.collect.Lists;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.ReflectionUtils;
//
//import java.beans.PropertyDescriptor;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.math.BigDecimal;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
///**
// * Created by katgr on 10.12.2017.
// */
//@Slf4j
//public class NativeQueryResultSetHandler {
//
//    public static <T> List<T> getResultList(List<Object[]> objects, Class<T> type) {
//        List<T> result = new ArrayList<>();
//        objects.forEach(e -> {
//            T obj = getResult(e, type);
//            result.add(obj);
//        });
//        return result;
//    }
//
//    public static <T> T getSingleResult(Object obj, Class<T> t) {
//        return getResult((Object[]) obj, t);
//    }
//
//    public static <T> T getResult(Object[] obj, Class<T> t) {
//        try {
//            T instance = t.newInstance();
//
//            for (Field field : getDeclaredFields(t)) {
//                field.setAccessible(true);
//                Column column = field.getDeclaredAnnotation(Column.class);
//                if (column != null) {
//                    int index = column.index();
//                    String localDateTimeFormat = column.localDateTimeFormat();
//                    boolean localDateTimeTimestamp = column.localDateTimeTimestamp();
//                    if(index >= obj.length && column.optional()){
//                        continue;
//                    }
//                    if (obj[index] != null) {
//                        assignValue(obj[index], field, null, instance, localDateTimeFormat, localDateTimeTimestamp);
//                    }
//                }
//            }
//
//            for (Method method : ReflectionUtils.getAllDeclaredMethods(t)) {
//                ReflectionUtils.makeAccessible(method);
//                Column column = method.getDeclaredAnnotation(Column.class);
//                if (column != null) {
//                    int index = column.index();
//                    boolean localDateTimeTimestamp = column.localDateTimeTimestamp();
//                    if(index >= obj.length && column.optional()){
//                        continue;
//                    }
//                    if (obj[index] != null) {
//                        assignValue(obj[index], null, method, instance, null, localDateTimeTimestamp);
//                    }
//                }
//            }
//
//            return instance;
//
//        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SQLException | SecurityException e) {
//            log.error("Error assigning result from Native Query", e);
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    private static <T> List<Field> getDeclaredFields(Class<T> clazz) {
//        ArrayList<Field> result = Lists.newArrayList(clazz.getDeclaredFields());
//        if (clazz.getSuperclass() != null) {
//            result.addAll(getDeclaredFields(clazz.getSuperclass()));
//        }
//        return result;
//    }
//
//    private static void assignValue(Object result, Field field, Method method, Object instance, String localDateTimeFormat,
//                                    boolean localDateTimeTimestamp) throws IllegalArgumentException, IllegalAccessException, SQLException {
//        try {
//            Class<?> type = getFieldOrMethodType(field, method);
//
//            if (Float.class.equals(type) || float.class.equals(type)) {
//                setValue(field, method, instance, result);
//            } else if (Integer.class.equals(type) || int.class.equals(type)) {
//                setValue(field, method, instance, Integer.valueOf(result.toString()));
//            } else if (Long.class.equals(type) || long.class.equals(type)) {
//                setValue(field, method, instance, Long.valueOf(result.toString()));
//            } else if (Double.class.equals(type) || double.class.equals(type)) {
//                setValue(field, method, instance, Double.valueOf(result.toString()));
//            } else if (BigDecimal.class.equals(type)) {
//                setValue(field, method, instance, result);
//            } else if (Boolean.class.equals(type) || boolean.class.equals(type)) {
//                if (Character.class.equals(result.getClass()) || String.class.equals(result.getClass())) {
//                    setValue(field, method, instance, (result.toString().equals("1")) ? true : false);
//                } else {
//                    setValue(field, method, instance, result);
//                }
//            } else if (String.class.equals(type)) {
//                setValue(field, method, instance, result.toString());
//            } else if (Character.class.equals(type)) {
//                setValue(field, method, instance, result);
//            } else {
//                if (field != null) {
//                    log.error("Unsupported field type: {}", field.getType());
//                    throw new RuntimeException("Unsupported field type for NativeQuery ResultSet");
//                }
//                if (method != null) {
//                    log.error("Unsupported method type: {}", method.getReturnType());
//                    throw new RuntimeException("Unsupported method type for NativeQuery ResultSet");
//                }
//                throw new RuntimeException("Unsupported state.");
//            }
//        } catch (IllegalAccessException e) {
//            throw e;
//        } catch (Exception e) {
//            String dataInfo = " Field name:" + (field != null ? field.getName() : "") + "\n";
//            dataInfo += " Field type:" + (field != null ? field.getType() : "") + "\n";
//            dataInfo += " Method name: " + (method != null ? method.getName() : "") + "\n";
//            dataInfo += " LocalTime format:" + localDateTimeFormat + "\n";
//            dataInfo += " LocalDateTimeTimestamp:" + localDateTimeTimestamp + "\n";
//            dataInfo += " Instance of:" + instance.toString() + "\n";
//            dataInfo += " Object value:" + result.toString() + "\n";
//            throw new RuntimeException(e.getMessage() + "\n" + dataInfo);
//        }
//    }
//
//    private static void setValue(Field field, Method method, Object instance, Object result) throws IllegalAccessException {
//        if (method != null) {
//            field = getField(method);
//        }
//
//        if (field != null) {
//            ReflectionUtils.makeAccessible(field);
//            field.set(instance, result);
//        }
//    }
//
//    private static Field getField(Method method) {
//        if (method == null) {
//            return null;
//        }
//
//        Field field = null;
//        PropertyDescriptor propertyForMethod = findPropertyForMethod(method, method.getDeclaringClass());
//
//        if (propertyForMethod != null) {
//            Class<?> clazz = method.getDeclaringClass();
//
//            field = ReflectionUtils.findField(clazz, propertyForMethod.getName());
//        }
//
//        return field;
//    }
//
//    private static Class<?> getMetodType(Method method) {
//        if (method == null) {
//            return null;
//        }
//        Class<?> clazz = null;
//
//        PropertyDescriptor propertyForMethod = findPropertyForMethod(method, method.getDeclaringClass());
//
//        if (propertyForMethod != null) {
//            clazz = propertyForMethod.getPropertyType();
//        }
//
//        return clazz;
//    }
//
//    private static Class<?> getFieldOrMethodType(Field field, Method method) {
//        Class<?> clazz = null;
//
//        if (field != null) {
//            clazz = field.getType();
//        } else {
//            clazz = getMetodType(method);
//        }
//
//        return clazz;
//    }
//
//    private static PropertyDescriptor findPropertyForMethod(Method method, Class<?> clazz) throws BeansException {
//        if (method == null) {
//            return null;
//        }
//
//        PropertyDescriptor propertyDescriptor = null;
//        PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(clazz);
//
//        for (PropertyDescriptor pd : pds) {
//            if (isMethodsEquals(method, pd.getReadMethod()) || isMethodsEquals(method, pd.getWriteMethod())) {
//                propertyDescriptor = pd;
//                break;
//            }
//        }
//        return propertyDescriptor;
//    }
//
//    private static boolean isMethodsEquals(Method method, Method other) {
//        return method != null && other != null && method.getName().equals(other.getName())
//                // && method.getReturnType().equals(other.getReturnType())
//                && Arrays.equals(method.getParameterTypes(), other.getParameterTypes());
//    }
//
////    @Autowired
////    public void setService(DictionaryService dictionaryService) {
////        NativeQueryResultSetHandler.service = dictionaryService;
////    }
//}
