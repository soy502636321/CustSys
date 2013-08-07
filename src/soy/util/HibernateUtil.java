package soy.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class HibernateUtil {
	public static List parseToVos(Collection collection, Class clazz) {
		List vos = new ArrayList();
		try {
			if (!SystemUtil.isNull(collection) && clazz != null) {
				Constructor constructor = null;
				Iterator iterator = collection.iterator();
				while (iterator.hasNext()) {
					Object object = (Object) iterator.next();
					if (constructor == null) {
						constructor = clazz.getConstructor(object.getClass());
					}
					Object vo = constructor.newInstance(object);
					vos.add(vo);
				}
			}
			collection = null;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vos;
	}
}
