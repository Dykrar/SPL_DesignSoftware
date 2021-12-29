/**
 * 
 */
package zirk.devices;

import com.bezirk.middleware.Bezirk;

import devices.DeviceType;
import zirk.events.LightSignalEvent;

public class SmartBulb extends Device {

	public SmartBulb(Bezirk bezirk) {
		super(bezirk, DeviceType.SMART_BULB);
	}

	public void sendEvent(LightSignalEvent event) {
		this.bezirk.sendEvent(event);
	}

}
