package module;

import org.apache.axis2.AxisFault;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.description.AxisDescription;
import org.apache.axis2.description.AxisModule;
import org.apache.axis2.modules.Module;
import org.apache.neethi.Assertion;
import org.apache.neethi.Policy;

public class LoggingModule implements Module {

	@Override
	public void applyPolicy(Policy arg0, AxisDescription arg1) throws AxisFault {
		

	}

	@Override
	public boolean canSupportAssertion(Assertion arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void engageNotify(AxisDescription arg0) throws AxisFault {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(ConfigurationContext arg0, AxisModule arg1)
			throws AxisFault {
		 System.out.println("init");
		
	}

	@Override
	public void shutdown(ConfigurationContext arg0) throws AxisFault {
		System.out.println("shutdown");

		
	}

}
