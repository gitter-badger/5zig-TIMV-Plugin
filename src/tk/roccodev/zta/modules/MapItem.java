package tk.roccodev.zta.modules;

import eu.the5zig.mod.modules.GameModeItem;
import tk.roccodev.zta.TIMV;
import tk.roccodev.zta.hiveapi.TIMVMap;

public class MapItem extends GameModeItem<TIMV>{

	public MapItem(){
		super(TIMV.class);
	}

	@Override
	protected Object getValue(boolean dummy) {
		TIMVMap map = TIMV.activeMap;
		if(map == null) return "Unknown map";
		String name = map.getDisplayName();
		StringBuilder tr = new StringBuilder();
		tr.append(name);
		if((boolean)getProperties().getSetting("showenderchests").get()){
			int a = map.getAccessibleEnderchests();
			int t = map.getTotalEnderchests();
			tr.append(" (");
			if((boolean)getProperties().getSetting("showaccessible").get()){
				tr.append(a);
			}
			if((boolean)getProperties().getSetting("showendertotal").get()){
				if((boolean)getProperties().getSetting("showaccessible").get()){
					tr.append(" / ").append(t);
				}
				else{
					tr.append(t);
				}
			}
			tr.append(")");
			
			
			
		}
		
		
		return tr.toString().trim(); 
	}
	
	@Override
	public void registerSettings() {
		// TODO Auto-generated method stub
		getProperties().addSetting("showaccessible", true);
		getProperties().addSetting("showendertotal", true);
		getProperties().addSetting("showenderchests", true);
	}

	@Override
	public String getName() {
		return "Map";
	}
	@Override
	public boolean shouldRender(boolean dummy){
		try{
		return dummy || (TIMV.shouldRender(getGameMode().getState()) && TIMV.activeMap != null);
		}catch(NullPointerException e){
			return false;
		}
	}

}
