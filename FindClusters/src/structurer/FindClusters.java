package structurer;


import java.util.ArrayList;
import java.util.Iterator;

import reporter.Reporter;



public class FindClusters  {
	
	public FindClusters(){
		super();
	}

	public void run() /* throws IOException */ {
		MatchMaker matchMaker = new MatchMaker ();
		ObjectModel model = new ObjectModel();
		Reporter reporter = new Reporter();
		
		ArrayList<Program> programs = model.getPrograms();
		ArrayList<TargetModule> ifsModules = model.getIFSModules();
		
		Iterator<Program>  programIterator  = programs.iterator();
		
		while (programIterator.hasNext()) {
			
			Program program = programIterator.next();
			
			matchMaker.findBestFittingModuleForProgram(program, ifsModules);
		}
		
		reporter.showModules(ifsModules);
		reporter.ShowSharedTables(ifsModules);
		
	}

	public static void main(String[] args) {

		FindClusters fc = new FindClusters();
		fc.run();

	}

}
