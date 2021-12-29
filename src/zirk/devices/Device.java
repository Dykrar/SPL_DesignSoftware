package zirk.devices;

import com.bezirk.middleware.Bezirk;

import dispositivos.TipoProduto;

public abstract class Device {

	protected final Bezirk bezirk;
	protected final TipoProduto tipoProduto;

	public Device(Bezirk bezirk, TipoProduto tipoProduto) {
		this.bezirk = bezirk;
		this.tipoProduto = tipoProduto;
	}

}
