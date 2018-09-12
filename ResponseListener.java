package com.payu;

import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;
import org.jpos.space.Space;
import org.jpos.space.SpaceFactory;

public class ResponseListener implements ISORequestListener, Configurable {
	
	private Space<String, ISOMsg> sp;
	
	@Override
	public boolean process(ISOSource source, ISOMsg msg) {
		sp.out(msg.getString(11), msg);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setConfiguration(Configuration conf)
			throws ConfigurationException {
		sp = SpaceFactory.getSpace(conf.get("space"));
	}

}