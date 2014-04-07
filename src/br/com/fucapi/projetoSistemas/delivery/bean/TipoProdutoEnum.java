package br.com.fucapi.projetoSistemas.delivery.bean;

public enum TipoProdutoEnum {
	/** 
	 * 1 - TIPO  SUSHI
	 */
	TIPO_SUSHI( 1,"SUSHI" ),

	/**
	 * 2 - TIPO  SUSHI HOT
	 */
	TIPO_SUSHI_HOT( 2, "SUSHI HOT" ),
	
	/**
	* 3 - TEMAKI
	*/
	TIPO_TEMAKI( 3, "TEMAKI" ),
	
	/**
	* 4 - TEMAKI HOT
	*/
	TIPO_TEMAKI_HOT( 4, "TEMAKI HOT" ),
	/**
	* 5 - SASHIMI
	*/
	TIPO_SASHIMI( 5, "SASHIMI" );

	private Integer key;
	private String name;

	private TipoProdutoEnum(Integer key, String name) {
		this.key = key;
		this.name = name;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static String getNameFormatado(int key) {
		switch (key) {
		case 1:
			return "Sushi";
		case 2:
			return "Sushi HOT";
		case 3:
			return "Temaki";
		case 4:
			return "Temaki HOT";
		case 5:
			return "SASHIMI";
		}
		return "Tipo Desconhecido.";
	}
}
