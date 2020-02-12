package roteador.core.component;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: eCatalogue
 * <p/>
 * Developer: Rodrigo Del Cistia Andrade
 * Created in:
 * - Date: 5/10/13
 * - Time: 1:14 PM
 */
public class AbstractRoutesConfigurator {
	private Map<String, String> routeConfigurations = new HashMap<String, String>();

	public String getRouteConfiguration(String key) {
	    return routeConfigurations.get(key);
	}

	public Map<String, String> getRouteConfigurations() {
	    return routeConfigurations;
	}

	public void setRouteConfigurations(Map<String, String> routeConfigurations) {
	    this.routeConfigurations = routeConfigurations;
	}
}
