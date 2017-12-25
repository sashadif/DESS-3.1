package libnet;
import PetriObj.ExceptionInvalidNetStructure;
import PetriObj.PetriNet;
import PetriObj.PetriP;
import PetriObj.PetriT;
import PetriObj.ArcIn;
import PetriObj.ArcOut;
import java.util.ArrayList;
import java.util.Random;
public class NetLibrary {

public static PetriNet CreateNetFR() throws ExceptionInvalidNetStructure {
	ArrayList<PetriP> d_P = new ArrayList<>();
	ArrayList<PetriT> d_T = new ArrayList<>();
	ArrayList<ArcIn> d_In = new ArrayList<>();
	ArrayList<ArcOut> d_Out = new ArrayList<>();
	d_P.add(new PetriP("P1",1));
	d_P.add(new PetriP("P2",0));
	d_P.add(new PetriP("P4",0));
	d_P.add(new PetriP("P6",0));
	d_P.add(new PetriP("LockA",1));
	d_P.add(new PetriP("P8",0));
	d_P.add(new PetriP("P9",0));
	d_P.add(new PetriP("LockB",1));
	d_P.add(new PetriP("P1",0));
	d_T.add(new PetriT("T1",1.0));
	d_T.add(new PetriT("startA",0.0));
	d_T.add(new PetriT("sleep",2.0));
	d_T.get(2).setDistribution("unif", d_T.get(2).getTimeServ());
	d_T.get(2).setParamDeviation(1.0);
	d_T.add(new PetriT("T6",0.0));
	d_T.get(3).setPriority(1);
	d_T.add(new PetriT("BowA",1.0));
	d_T.get(4).setPriority(1);
	d_T.add(new PetriT("BowBackA",1.0));
	d_T.add(new PetriT("T1",0.0));
	d_T.add(new PetriT("T2",0.0));
	d_T.add(new PetriT("T5",0.0));
	d_In.add(new ArcIn(d_P.get(0),d_T.get(0),1));
	d_In.add(new ArcIn(d_P.get(1),d_T.get(1),1));
	d_In.add(new ArcIn(d_P.get(2),d_T.get(2),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(3),1));
	d_In.add(new ArcIn(d_P.get(3),d_T.get(3),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(4),1));
	d_In.add(new ArcIn(d_P.get(6),d_T.get(5),1));
	d_In.add(new ArcIn(d_P.get(7),d_T.get(4),1));
	d_In.add(new ArcIn(d_P.get(3),d_T.get(6),1));
	d_In.add(new ArcIn(d_P.get(8),d_T.get(7),1));
	d_In.add(new ArcIn(d_P.get(7),d_T.get(7),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(8),1));
	d_Out.add(new ArcOut(d_T.get(0),d_P.get(1),1));
	d_Out.add(new ArcOut(d_T.get(1),d_P.get(2),1));
	d_Out.add(new ArcOut(d_T.get(2),d_P.get(3),1));
	d_Out.add(new ArcOut(d_T.get(3),d_P.get(5),1));
	d_Out.add(new ArcOut(d_T.get(4),d_P.get(6),1));
	d_Out.add(new ArcOut(d_T.get(5),d_P.get(7),1));
	d_Out.add(new ArcOut(d_T.get(5),d_P.get(4),1));
	d_Out.add(new ArcOut(d_T.get(5),d_P.get(2),1));
	d_Out.add(new ArcOut(d_T.get(6),d_P.get(8),1));
	d_Out.add(new ArcOut(d_T.get(7),d_P.get(7),1));
	d_Out.add(new ArcOut(d_T.get(8),d_P.get(4),1));
	d_Out.add(new ArcOut(d_T.get(7),d_P.get(2),1));
	d_Out.add(new ArcOut(d_T.get(8),d_P.get(2),1));
	PetriNet d_Net = new PetriNet("FR",d_P,d_T,d_In,d_Out);
	PetriP.initNext();
	PetriT.initNext();
	ArcIn.initNext();
	ArcOut.initNext();

	return d_Net;
}
public static PetriNet CreateNetFriend(String name, int loop) throws ExceptionInvalidNetStructure {
	double delay = 100.0;
        double x=0.00000001;
    ArrayList<PetriP> d_P = new ArrayList<>();
	ArrayList<PetriT> d_T = new ArrayList<>();
	ArrayList<ArcIn> d_In = new ArrayList<>();
	ArrayList<ArcOut> d_Out = new ArrayList<>();
        Random r = new Random();
	d_P.add(new PetriP("bow{",0));
	d_P.add(new PetriP("P2",0));
	d_P.add(new PetriP("lock",1));
	d_P.add(new PetriP("P4",0));
	d_P.add(new PetriP("P5",0));
	d_P.add(new PetriP("P6",0));
	d_P.add(new PetriP("failure++",0));
	d_P.add(new PetriP("lockOther",1));
	d_P.add(new PetriP("bowA++",0));
	d_P.add(new PetriP("P10",0));
	d_P.add(new PetriP("bowB++",0));
	d_P.add(new PetriP("P15",0));
	d_P.add(new PetriP("bowLoop{",loop));
	d_P.add(new PetriP("bow}",0));
	d_P.add(new PetriP("Core",1));
	d_T.add(new PetriT("imp{",delay*x));// was delay
        d_T.get(0).setDistribution("norm", d_T.get(0).getTimeServ()*0.1);
	d_T.add(new PetriT("tryLockA",delay*x,1));//priority = 1
	d_T.get(1).setDistribution("norm", d_T.get(1).getTimeServ()*0.1);
        d_T.add(new PetriT("0&?",0.0));
	d_T.add(new PetriT("tryLockB",delay*x,1));//priority = 1
	d_T.get(3).setDistribution("norm", d_T.get(3).getTimeServ()*0.1);
        d_T.add(new PetriT("bowBack{}",delay)); //delay*x
	d_T.get(4).setDistribution("norm", d_T.get(4).getTimeServ()*0.1);
        d_T.add(new PetriT("unlockA",0.0));
	d_T.add(new PetriT("0&1",0.0,1)); //priority = 1
	d_T.add(new PetriT("failure",0.0));
	d_T.add(new PetriT("unlockAB",0.0));
	d_T.add(new PetriT("unlockB",0.0));
	d_T.add(new PetriT("for{",delay)); //sleep
	d_T.get(10).setDistribution("norm", d_T.get(10).getTimeServ()*0.1);
        d_T.add(new PetriT("for}",0.0+r.nextDouble()));
	d_In.add(new ArcIn(d_P.get(0),d_T.get(0),1));
	d_In.add(new ArcIn(d_P.get(1),d_T.get(1),1));
	d_In.add(new ArcIn(d_P.get(1),d_T.get(2),1));
	d_In.add(new ArcIn(d_P.get(2),d_T.get(1),1));
	d_In.add(new ArcIn(d_P.get(3),d_T.get(3),1));
	d_In.add(new ArcIn(d_P.get(7),d_T.get(3),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(4),1));
	d_In.add(new ArcIn(d_P.get(3),d_T.get(5),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(6),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(7),1));
	d_In.add(new ArcIn(d_P.get(7),d_T.get(6),1));
	d_In.add(new ArcIn(d_P.get(9),d_T.get(8),1));
	d_In.add(new ArcIn(d_P.get(11),d_T.get(9),1));
	d_In.add(new ArcIn(d_P.get(12),d_T.get(10),1));
	d_In.add(new ArcIn(d_P.get(13),d_T.get(11),1));
	d_In.add(new ArcIn(d_P.get(14),d_T.get(10),1));
	d_Out.add(new ArcOut(d_T.get(0),d_P.get(1),1));
	d_Out.add(new ArcOut(d_T.get(1),d_P.get(3),1));
	d_Out.add(new ArcOut(d_T.get(2),d_P.get(4),1));
	d_Out.add(new ArcOut(d_T.get(3),d_P.get(5),1));
	d_Out.add(new ArcOut(d_T.get(5),d_P.get(2),1));
	d_Out.add(new ArcOut(d_T.get(4),d_P.get(9),1));
	d_Out.add(new ArcOut(d_T.get(7),d_P.get(6),1));
	d_Out.add(new ArcOut(d_T.get(3),d_P.get(8),1));
	d_Out.add(new ArcOut(d_T.get(4),d_P.get(10),1));
	d_Out.add(new ArcOut(d_T.get(8),d_P.get(2),1));
	d_Out.add(new ArcOut(d_T.get(8),d_P.get(7),1));
	d_Out.add(new ArcOut(d_T.get(6),d_P.get(11),1));
	d_Out.add(new ArcOut(d_T.get(9),d_P.get(7),1));
	d_Out.add(new ArcOut(d_T.get(10),d_P.get(0),1));
	d_Out.add(new ArcOut(d_T.get(8),d_P.get(13),1));
	d_Out.add(new ArcOut(d_T.get(11),d_P.get(14),1));
	d_Out.add(new ArcOut(d_T.get(5),d_P.get(13),1));
	d_Out.add(new ArcOut(d_T.get(9),d_P.get(13),1));
	d_Out.add(new ArcOut(d_T.get(7),d_P.get(13),1));
	d_Out.add(new ArcOut(d_T.get(9),d_P.get(6),1));
	d_Out.add(new ArcOut(d_T.get(5),d_P.get(6),1));
	PetriNet d_Net = new PetriNet("Friend "+name,d_P,d_T,d_In,d_Out);
	PetriP.initNext();
	PetriT.initNext();
	ArcIn.initNext();
	ArcOut.initNext();

	return d_Net;
}
public static PetriNet CreateNetFriendUsingCores(String name, int loop, int cores) throws ExceptionInvalidNetStructure {
	double delay = 100.0;
        double x=0.8;
    ArrayList<PetriP> d_P = new ArrayList<>();
	ArrayList<PetriT> d_T = new ArrayList<>();
	ArrayList<ArcIn> d_In = new ArrayList<>();
	ArrayList<ArcOut> d_Out = new ArrayList<>();
        Random r = new Random();
	d_P.add(new PetriP("bow{",0));
	d_P.add(new PetriP("P2",0));
	d_P.add(new PetriP("lock",1));
	d_P.add(new PetriP("P4",0));
	d_P.add(new PetriP("P5",0));
	d_P.add(new PetriP("P6",0));
	d_P.add(new PetriP("failure++",0));
	d_P.add(new PetriP("lockOther",1));
	d_P.add(new PetriP("bowA++",0));
	d_P.add(new PetriP("P10",0));
	d_P.add(new PetriP("bowB++",0));
	d_P.add(new PetriP("P15",0));
	d_P.add(new PetriP("bowLoop{",loop));
	d_P.add(new PetriP("bow}",0));
	d_P.add(new PetriP("Cycle",1));
        d_P.add(new PetriP("Core",cores));
	d_T.add(new PetriT("imp{",delay*x));// was delay
        d_T.get(0).setDistribution("norm", d_T.get(0).getTimeServ()*0.1);
	d_T.add(new PetriT("tryLockA",delay*x,1));//priority = 1
	d_T.get(1).setDistribution("norm", d_T.get(1).getTimeServ()*0.1);
        d_T.add(new PetriT("0&?",0.0));
	d_T.add(new PetriT("tryLockB",delay*x,1));//priority = 1
	d_T.get(3).setDistribution("norm", d_T.get(3).getTimeServ()*0.1);
        d_T.add(new PetriT("bowBack{}",delay*x)); //delay*x
	d_T.get(4).setDistribution("norm", d_T.get(4).getTimeServ()*0.1);
        d_T.add(new PetriT("unlockA",0.0));
	d_T.add(new PetriT("0&1",0.0,1)); //priority = 1
	d_T.add(new PetriT("failure",0.0));
	d_T.add(new PetriT("unlockAB",0.0));
	d_T.add(new PetriT("unlockB",0.0));
	d_T.add(new PetriT("for{",delay)); //sleep
	d_T.get(10).setDistribution("norm", d_T.get(10).getTimeServ()*0.1);
        d_T.add(new PetriT("for}",0.0+r.nextDouble()));
	d_In.add(new ArcIn(d_P.get(0),d_T.get(0),1));
	d_In.add(new ArcIn(d_P.get(1),d_T.get(1),1));
	d_In.add(new ArcIn(d_P.get(1),d_T.get(2),1));
	d_In.add(new ArcIn(d_P.get(2),d_T.get(1),1));
	d_In.add(new ArcIn(d_P.get(3),d_T.get(3),1));
	d_In.add(new ArcIn(d_P.get(7),d_T.get(3),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(4),1));
	d_In.add(new ArcIn(d_P.get(3),d_T.get(5),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(6),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(7),1));
	d_In.add(new ArcIn(d_P.get(7),d_T.get(6),1));
	d_In.add(new ArcIn(d_P.get(9),d_T.get(8),1));
	d_In.add(new ArcIn(d_P.get(11),d_T.get(9),1));
	d_In.add(new ArcIn(d_P.get(12),d_T.get(10),1));
	d_In.add(new ArcIn(d_P.get(13),d_T.get(11),1));
	d_In.add(new ArcIn(d_P.get(14),d_T.get(10),1));
	d_Out.add(new ArcOut(d_T.get(0),d_P.get(1),1));
	d_Out.add(new ArcOut(d_T.get(1),d_P.get(3),1));
	d_Out.add(new ArcOut(d_T.get(2),d_P.get(4),1));
	d_Out.add(new ArcOut(d_T.get(3),d_P.get(5),1));
	d_Out.add(new ArcOut(d_T.get(5),d_P.get(2),1));
	d_Out.add(new ArcOut(d_T.get(4),d_P.get(9),1));
	d_Out.add(new ArcOut(d_T.get(7),d_P.get(6),1));
	d_Out.add(new ArcOut(d_T.get(3),d_P.get(8),1));
	d_Out.add(new ArcOut(d_T.get(4),d_P.get(10),1));
	d_Out.add(new ArcOut(d_T.get(8),d_P.get(2),1));
	d_Out.add(new ArcOut(d_T.get(8),d_P.get(7),1));
	d_Out.add(new ArcOut(d_T.get(6),d_P.get(11),1));
	d_Out.add(new ArcOut(d_T.get(9),d_P.get(7),1));
	d_Out.add(new ArcOut(d_T.get(10),d_P.get(0),1));
	d_Out.add(new ArcOut(d_T.get(8),d_P.get(13),1));
	d_Out.add(new ArcOut(d_T.get(11),d_P.get(14),1));
	d_Out.add(new ArcOut(d_T.get(5),d_P.get(13),1));
	d_Out.add(new ArcOut(d_T.get(9),d_P.get(13),1));
	d_Out.add(new ArcOut(d_T.get(7),d_P.get(13),1));
	d_Out.add(new ArcOut(d_T.get(9),d_P.get(6),1));
	d_Out.add(new ArcOut(d_T.get(5),d_P.get(6),1));
        for(PetriT transition: d_T){ // Core bound
            d_In.add(new ArcIn(d_P.get(15),transition,1));
            d_Out.add(new ArcOut(transition,d_P.get(15),1));
        }
        
	PetriNet d_Net = new PetriNet("Friend "+name,d_P,d_T,d_In,d_Out);
	PetriP.initNext();
	PetriT.initNext();
	ArcIn.initNext();
	ArcOut.initNext();

	return d_Net;
}


public static PetriNet CreateNetFriend_2() throws ExceptionInvalidNetStructure {
	ArrayList<PetriP> d_P = new ArrayList<>();
	ArrayList<PetriT> d_T = new ArrayList<>();
	ArrayList<ArcIn> d_In = new ArrayList<>();
	ArrayList<ArcOut> d_Out = new ArrayList<>();
	d_P.add(new PetriP("bow{",0));
	d_P.add(new PetriP("P2",0));
	d_P.add(new PetriP("lockA",1));
	d_P.add(new PetriP("P4",0));
	d_P.add(new PetriP("P5",0));
	d_P.add(new PetriP("P6",0));
	d_P.add(new PetriP("failure++",0));
	d_P.add(new PetriP("lockB",1));
	d_P.add(new PetriP("bowA++",0));
	d_P.add(new PetriP("P10",0));
	d_P.add(new PetriP("bowB++",0));
	d_P.add(new PetriP("P15",0));
	d_P.add(new PetriP("bowLoop{",1000));
	d_P.add(new PetriP("bow}",0));
	d_P.add(new PetriP("Core",1));
	d_T.add(new PetriT("imp{",1.0));
	d_T.add(new PetriT("tryLockA",10.0));
	d_T.get(1).setPriority(1);
	d_T.add(new PetriT("0&?",10.0));
	d_T.add(new PetriT("tryLockB",100.0));
	d_T.get(3).setPriority(1);
	d_T.add(new PetriT("bowBack{}",100.0));
	d_T.add(new PetriT("unlockA",10.0));
	d_T.add(new PetriT("0&1",10.0));
	d_T.add(new PetriT("failure",10.0));
	d_T.add(new PetriT("unlockAB",10.0));
	d_T.add(new PetriT("unlockB",10.0));
	d_T.add(new PetriT("for{",1000.0));
	d_T.add(new PetriT("for}",0.0));
	d_In.add(new ArcIn(d_P.get(0),d_T.get(0),1));
	d_In.add(new ArcIn(d_P.get(1),d_T.get(1),1));
	d_In.add(new ArcIn(d_P.get(1),d_T.get(2),1));
	d_In.add(new ArcIn(d_P.get(2),d_T.get(1),1));
	d_In.add(new ArcIn(d_P.get(3),d_T.get(3),1));
	d_In.add(new ArcIn(d_P.get(7),d_T.get(3),1));
	d_In.add(new ArcIn(d_P.get(5),d_T.get(4),1));
	d_In.add(new ArcIn(d_P.get(3),d_T.get(5),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(6),1));
	d_In.add(new ArcIn(d_P.get(4),d_T.get(7),1));
	d_In.add(new ArcIn(d_P.get(7),d_T.get(6),1));
	d_In.add(new ArcIn(d_P.get(9),d_T.get(8),1));
	d_In.add(new ArcIn(d_P.get(11),d_T.get(9),1));
	d_In.add(new ArcIn(d_P.get(12),d_T.get(10),1));
	d_In.add(new ArcIn(d_P.get(13),d_T.get(11),1));
	d_In.add(new ArcIn(d_P.get(14),d_T.get(10),1));
	d_Out.add(new ArcOut(d_T.get(0),d_P.get(1),1));
	d_Out.add(new ArcOut(d_T.get(1),d_P.get(3),1));
	d_Out.add(new ArcOut(d_T.get(2),d_P.get(4),1));
	d_Out.add(new ArcOut(d_T.get(3),d_P.get(5),1));
	d_Out.add(new ArcOut(d_T.get(5),d_P.get(2),1));
	d_Out.add(new ArcOut(d_T.get(4),d_P.get(9),1));
	d_Out.add(new ArcOut(d_T.get(7),d_P.get(6),1));
	d_Out.add(new ArcOut(d_T.get(3),d_P.get(8),1));
	d_Out.add(new ArcOut(d_T.get(4),d_P.get(10),1));
	d_Out.add(new ArcOut(d_T.get(8),d_P.get(2),1));
	d_Out.add(new ArcOut(d_T.get(8),d_P.get(7),1));
	d_Out.add(new ArcOut(d_T.get(6),d_P.get(11),1));
	d_Out.add(new ArcOut(d_T.get(9),d_P.get(7),1));
	d_Out.add(new ArcOut(d_T.get(10),d_P.get(0),1));
	d_Out.add(new ArcOut(d_T.get(8),d_P.get(13),1));
	d_Out.add(new ArcOut(d_T.get(11),d_P.get(14),1));
	d_Out.add(new ArcOut(d_T.get(5),d_P.get(13),1));
	d_Out.add(new ArcOut(d_T.get(9),d_P.get(13),1));
	d_Out.add(new ArcOut(d_T.get(7),d_P.get(13),1));
	d_Out.add(new ArcOut(d_T.get(9),d_P.get(6),1));
	d_Out.add(new ArcOut(d_T.get(5),d_P.get(6),1));
	PetriNet d_Net = new PetriNet("friend14",d_P,d_T,d_In,d_Out);
	PetriP.initNext();
	PetriT.initNext();
	ArcIn.initNext();
	ArcOut.initNext();

	return d_Net;
}
}