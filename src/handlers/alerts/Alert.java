
package handlers.alerts;

public abstract class Alert {
	
	private AlertType alertType;
	
	/**
	 * @param alertType
	 */
	public Alert(AlertType alertType) {
		this.alertType = alertType;
	}

	/**
	 * @return the alertType
	 */
	public AlertType getAlertType() {
		return alertType;
	}	
	
}
