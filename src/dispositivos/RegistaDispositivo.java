package dispositivos;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

public abstract class RegistaDispositivo {
	
	protected final Bezirk bezirk;

	public RegistaDispositivo(TipoProduto tipoProduto) {
		BezirkMiddleware.initialize();
        this.bezirk = BezirkMiddleware.registerZirk(tipoProduto.name());
	}	
}
