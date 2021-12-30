package dispositivos.bezirk;

import com.bezirk.middleware.Bezirk;

import dispositivos.TipoProduto;

public abstract class Dispositivo {

	protected final Bezirk bezirk;
	protected final TipoProduto deviceType;

	public Dispositivo(Bezirk bezirk, TipoProduto deviceType) {
		this.bezirk = bezirk;
		this.deviceType = deviceType;
	}
}
