package roteador.core;

import com.thoughtworks.xstream.XStream;

/**
 * Project: eCatalogue
 * <p/>
 * Developer: Rodrigo Del Cistia Andrade
 * Created in:
 * - Date: 5/15/13
 * - Time: 11:50 AM
 */
public class XStreamHelper {

	private XStream xstream;

	private XStreamHelper() {
		xstream = new XStream();
	}

	// -- Convenience methods
	public static String toXml(Object obj) {
		return InstanceDepot.INSTANCE.xstream.toXML(obj);
	}

	public static Object fromXml(String xml) {
		return InstanceDepot.INSTANCE.xstream.fromXML(xml);
	}

	public XStream getXstream() {
		return xstream;
	}

	// -- Singleton managing
	public static XStreamHelper getInstance() {
		return InstanceDepot.INSTANCE;
	}

	private static class InstanceDepot {
		public static final XStreamHelper INSTANCE = new XStreamHelper();

	}
}
