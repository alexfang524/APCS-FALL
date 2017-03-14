
public class ASCLLand {
	private int position;
	
	public ASCLLand (int firstPosition){
		this.position = firstPosition;
	}

	public int getPosition(){
		return this.position;
	}
	
	public void setPosition(int move){
		this.position += move;
		if (this.position < 0){
			this.position = 0;
		}
	}
	
	
}
