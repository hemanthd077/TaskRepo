package enumFiles;

public enum colors {
	
	VIOLET(1),
	INDIGO(2),
	BLUE(3),
	GREEN(4),
	YELLOW(5),
	ORANGE(6),
	RED(6);
	
	private int code;
	
	private colors(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}
