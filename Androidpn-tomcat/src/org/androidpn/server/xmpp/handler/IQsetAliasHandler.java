package org.androidpn.server.xmpp.handler;

import org.androidpn.server.xmpp.UnauthorizedException;
import org.androidpn.server.xmpp.session.ClientSession;
import org.androidpn.server.xmpp.session.Session;
import org.androidpn.server.xmpp.session.SessionManager;
import org.dom4j.Element;
import org.xmpp.packet.IQ;
import org.xmpp.packet.PacketError;


public class IQsetAliasHandler extends IQHandler {

	private static final String NAMESPACE = "androidpn:iq:setalias";
	
	private SessionManager sessionManager;
	
	public IQsetAliasHandler(){
		sessionManager = sessionManager.getInstance();
	}
	@Override
	public IQ handleIQ(IQ packet) throws UnauthorizedException {
		IQ reply = null;
		
		ClientSession session = sessionManager.getSession(packet.getFrom());
        if (session == null) {
            log.error("Session not found for key " + packet.getFrom());
            reply = IQ.createResultIQ(packet);
            reply.setChildElement(packet.getChildElement().createCopy());
            reply.setError(PacketError.Condition.internal_server_error);
            return reply;
        }
        if(session.getStatus()==Session.STATUS_AUTHENTICATED){
        	if(IQ.Type.set.equals(packet.getType())){
        		Element element = packet.getChildElement();
        		String username = element.elementText("username");
        		String alias = element.elementText("alias");
        		if(username != null&&!username.equals("")&&alias!= null &&!alias.equals(""))
        			sessionManager.setUserAlias(username, alias);
        		}
        }
		return null;
	}

	@Override
	public String getNamespace() {
		return NAMESPACE;
	}

}
