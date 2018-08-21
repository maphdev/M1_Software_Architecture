/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package soldier.core;

public class EquipmentException extends RuntimeException {
	private static final long serialVersionUID = -8530426939233341651L;

	public EquipmentException() {
		super();
	}

	public EquipmentException(String arg0) {
		super(arg0);
	}

	public EquipmentException(Throwable arg0) {
		super(arg0);
	}

	public EquipmentException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
