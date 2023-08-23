package components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("OctopusHeartObj")
public class OctopusHeart implements Heart {
	
	@Value("${octopus-heart}")
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
		return "OctopusHeart [numberOfHearts=" + numberOfHearts + "]";
	}
}
