package com.pioneercoders.roomexp.xml;

import com.pioneercoders.roomexp.common.IConfig;

public interface IRoommateEntryManager extends IConfig {
	
	void addRoommate(String name, String email,String mobile);
	
	void removeRoommate(String email);

	public String getRoomatesEmailList();
}
