package com.payu;


import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.MUX;
import org.jpos.q2.QBeanSupport;
import org.jpos.space.Space;
import org.jpos.space.SpaceFactory;
import org.jpos.util.NameRegistrar;

public class ChannelManager extends QBeanSupport {
	private long MAX_TIME_OUT;
	private MUX mux;

	@Override
	protected void initService() throws ISOException {
		log.info("initializing ChannelManager Service");
		try {
			mux = (MUX) NameRegistrar.get("mux." + cfg.get("mux"));
			MAX_TIME_OUT = cfg.getLong("timeout");
			NameRegistrar.register("manager", this);
		} catch (NameRegistrar.NotFoundException e) {
			log.error("Error in initializing service :" + e.getMessage());
		}

	}

	public ISOMsg sendMsg(ISOMsg m) throws Exception {
		return sendMsg(m, mux, MAX_TIME_OUT);
	}

	@SuppressWarnings({"unchecked" })
	private ISOMsg sendMsg(ISOMsg msg, MUX mux, long time) throws Exception {

		if (mux != null) {
			long start = System.currentTimeMillis();
			mux.request(msg, 1);
			String msgId = msg.getString(11);
			Space<String, ISOMsg> space = SpaceFactory.getSpace("tspace:mySpace");
			ISOMsg responseInSpace = space.in(msgId, 10000L);
			long duration = System.currentTimeMillis() - start;
			log.info("Response time (ms):" + duration);
			return responseInSpace;
		}
		return null;
	}
}