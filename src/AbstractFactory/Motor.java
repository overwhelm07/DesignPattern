package AbstractFactory;


abstract class Motor{
	static enum MotorStatus{
		AUTO, LOCAL, PAUSED, OFFLINE
	}
	private MotorStatus motorStatus;
	
	public Motor() {motorStatus=MotorStatus.AUTO;}
	public MotorStatus getStatus() {
		return motorStatus;
	}
	public void run() {
		if(motorStatus != MotorStatus.AUTO) {
			return;
		}
		
		doRun();
	}
	public void stop() {
		if(motorStatus == MotorStatus.AUTO) {
			motorStatus = MotorStatus.PAUSED;
			doStop();
		}
	}
	
	public void setStatus(MotorStatus motorStatus) {
		this.motorStatus = motorStatus;
	}
	
	protected abstract void doRun();
	protected abstract void doStop();
	
}

class SamsungMotor extends Motor{

	@Override
	protected void doRun() {
		System.out.println("do Run SamsungMotor");
	}

	@Override
	protected void doStop() {
		System.out.println("do Stop SamsungMotor");
		
	}
}

class LGMotor extends Motor{

	@Override
	protected void doRun() {
		System.out.println("do Run LGMotor");
	}

	@Override
	protected void doStop() {
		System.out.println("do Stop LGMotor");
		
	}
}