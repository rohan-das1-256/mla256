package fileHandling;

import java.io.Serializable;

public class PlayersData implements Serializable {

	private static final  long serialVersionUID =1L;
	public int id;
	public String name;
	public String type;
	
	public PlayersData(int id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "PlayersData [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

}
