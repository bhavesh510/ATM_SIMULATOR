package com.atm.serviceinterface;
import java.util.List;

import com.atm.entities.MiniStatement;

public interface MinistatementServiceInterface {
	List<MiniStatement> sendMinistatementList(int custId);
}
