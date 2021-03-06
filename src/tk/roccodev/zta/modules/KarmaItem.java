package tk.roccodev.zta.modules;

import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.modules.GameModeItem;
import eu.the5zig.mod.render.RenderLocation;
import eu.the5zig.mod.server.GameState;
import tk.roccodev.zta.TIMV;
import tk.roccodev.zta.hiveapi.HiveAPI;

public class KarmaItem extends GameModeItem<TIMV> {

	public KarmaItem(){
		super(TIMV.class);
	}

	@Override
	protected Object getValue(boolean dummy) {
		
		try{
			
		return HiveAPI.karma;
		}catch(Exception e){
			e.printStackTrace();
			return "Server error";
		}
	}

	@Override
	public String getName() {
		return "Karma";
	}
	
	
	
	@Override
	public boolean shouldRender(boolean dummy){
		try{
		return dummy || TIMV.shouldRender(getGameMode().getState());
		}catch(NullPointerException e){
			return false;
		}
	}

}
