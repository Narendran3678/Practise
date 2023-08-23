package components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("LivingBeingObj")
public class LivingBeing {
	
	@Autowired
	@Qualifier("OctopusHeartObj")
	private Heart heart;

	public LivingBeing(Heart heart) {
		super();
		this.heart = heart;
	}

	public void beingDetail()
	{
		System.out.println(heart);
	}
	
	public Heart getHeart() {
		return heart;
	}

	public void setHeart(Heart heart) {
		this.heart = heart;
	}

	@Override
	public String toString() {
		return "LivingBeing [heart=" + heart + "]";
	}
	
	
}
