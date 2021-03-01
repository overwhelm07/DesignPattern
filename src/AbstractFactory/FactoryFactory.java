package AbstractFactory;

/**
 * 
 * @author jh
 * 
 * 생성 패턴: 객체 생성과 조합을 캡슐화해 특정 객체가 생성되거나 변경되어도 프로그램 구조에 영향을 크게 받지 않도록 유연성을 제공
 * 추상팩토리, 싱글톤, 팩토리메소드..etc
 * 
AbstractFactory : 실제 팩토리 클래스의 공통 인터페이스
ConcrteFactory : Abstract을 override 후 구제적인 제품 생성
AbstractProduct : 제품의 공통 인터페이스 
ConcreteProduct : 구체적인 팩토리 클래스에서 생성되는 구체적인 제품
 */


public class FactoryFactory{
	public static Factory getFactory(VendorId vnedorId) {
		Factory factory = null;
		
		switch (vnedorId) {
		case LG:
			factory = LGFactory.getInstance();
			break;
		case SAMSUNG:
			factory = SAMSUNGFactory.getInstance();
			break;
		default:
			break;
		}
		
		return factory;
	}
}

abstract class Factory{
	public abstract Motor createMotor();
}

class LGFactory extends Factory {

	private LGFactory() {
	};

	private static Factory factory;

	public static Factory getInstance() {
		if (factory == null) {
			factory = new LGFactory();
		}
		return factory;
	}

	@Override
	public Motor createMotor() {
		return new LGMotor();
	}

}

class SAMSUNGFactory extends Factory {

	private SAMSUNGFactory() {
	};

	private static Factory factory;

	public static Factory getInstance() {
		if (factory == null) {
			factory = new SAMSUNGFactory();
		}
		return factory;
	}

	@Override
	public Motor createMotor() {
		return new SamsungMotor();
	}

}