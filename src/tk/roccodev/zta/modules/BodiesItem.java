package tk.roccodev.zta.modules;

import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.modules.GameModeItem;
import eu.the5zig.mod.render.RenderLocation;
import eu.the5zig.mod.server.GameState;
import tk.roccodev.zta.TIMV;
import tk.roccodev.zta.hiveapi.HiveAPI;

public class BodiesItem extends GameModeItem<TIMV> {

	public BodiesItem(){
		super(TIMV.class);
	}

	@Override
	protected Object getValue(boolean dummy) {
		
		return TIMV.traitorsDiscovered + "/" + TIMV.traitorsBefore + " Traitors";
		
	}

	@Override
	public String getName() {
		return "Discovered";
	}
	
	
	
	@Override
	public boolean shouldRender(boolean dummy){
		try{
		return dummy || (getGameMode().getState() == GameState.GAME && TIMV.traitorsDiscovered != 0);
		}catch(NullPointerException e){
			return false;
		}
	}

}
