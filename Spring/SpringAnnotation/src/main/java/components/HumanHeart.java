package components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("HumanHeartObj")
@Primary
public class HumanHeart implements Heart{
	
	@Value("${human-heart}")
	private String numberOfHearts;
	@Override
	public String numberOfHearts() {
		return numberOfHearts;
	}
	
	public String getNumberOfHearts() {
		return numberOfHearts;
	}

	public void setNumberOfHearts(String numberOfHearts) {
		this.numberOfHearts = numberOfHearts;
	}

	@Override
	public String toString() {
		return "HumanHeart [numberOfHearts=" + numberOfHearts + "]";
	}
	
}
