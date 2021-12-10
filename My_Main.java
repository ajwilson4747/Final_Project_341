public class My_Main {

	public static void main(String[] args) {
		// generate Canvas View
		Canvas canvas = new Canvas();
		canvas.requestFocus();
		//canvas.setForeground(Color.BLACK);

		// create instance of type C icon
		Type_C_GameObject myC = new Type_C_GameObject(255, 475);
		Type_A myA = new Type_A(355, 55);
		Type_B_GameObject myB = new Type_B_GameObject(455, 365);
		Type_D_GameObject myD = new Type_D_GameObject(10, 150);
		Type_D_Adapter myAdapter = new Type_D_Adapter(myB);
		
		// add objects to the canvas
		canvas.addGameObjs(myA);
		canvas.addGameObjs(myB);
		canvas.addGameObjs(myC);
		canvas.addGameObjs(myD);
		//canvas.addGameObjs(myAdapter);
		
		
		canvas.addKeyListener(myA);
		canvas.addKeyListener(myAdapter);
		canvas.addKeyListener(myC);
		canvas.addKeyListener(myD);

		
	}
		}
