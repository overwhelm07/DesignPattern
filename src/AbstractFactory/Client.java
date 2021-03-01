package AbstractFactory;

public class Client {
	public static void main(String[] args) {
		String vendorName = "LG";
		VendorId vendorId = null;
		
		if(vendorName.equalsIgnoreCase(VendorId.LG.name())) {
			vendorId = VendorId.LG;
		}
		else if (vendorName.equalsIgnoreCase(VendorId.SAMSUNG.name())) {
			vendorId = VendorId.SAMSUNG;
		}
		
		try {
			if(vendorId == null) {
				throw new Exception();
			}
			
			Factory factory = FactoryFactory.getFactory(vendorId);
			
			Motor motor = factory.createMotor();
			
			motor.run();
			motor.stop();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("vendorId is null");
		}
		
	}
}
