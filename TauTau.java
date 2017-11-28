package Alonzo_GuerreroMonroy;
import robocode.*;
import robocode.AdvancedRobot;
import robocode.util.Utils;



public class TauTau extends AdvancedRobot
{
	int Direction = 1;
	public void run() 
	{
		setAdjustRadarForRobotTurn(true);
		setAdjustGunForRobotTurn(true);
		turnRadarRightRadians(Double.POSITIVE_INFINITY);
	}
 
	public void onScannedRobot(ScannedRobotEvent e) 
	{
		double Heading = getHeadingRadians();
		double gunHeading = getGunHeadingRadians();
		double velocity = getVelocity();
		double absoluteBearing = Heading + e.getBearingRadians();
		setTurnRadarLeftRadians(getRadarTurnRemainingRadians());
		if(Math.random()>.9)
		{
			Direction = -Direction;
		}

		if (e.getDistance() > 180) 
		{
			setTurnGunRightRadians(Utils.normalRelativeAngle(absoluteBearing - 
			gunHeading + (e.getVelocity() * Math.sin(e.getHeadingRadians() - 
    		absoluteBearing) / 13.0)));
			setTurnRightRadians(Utils.normalRelativeAngle(absoluteBearing - Heading + (e.getVelocity() * 
			Math.sin(e.getHeadingRadians() - absoluteBearing))/velocity));
			setAhead((e.getDistance() - 140) * Direction);
			setFire(1);
		}
		else
		{
			setTurnGunRightRadians(Utils.normalRelativeAngle(absoluteBearing - 
    		gunHeading + (e.getVelocity() * Math.sin(e.getHeadingRadians() - 
    		absoluteBearing) / 13.0)));
			setTurnLeft(-90- e.getBearing());
			setAhead((e.getDistance() - 140) * Direction);
			setFire(2);
		}	
	}
	public void onHitByBullet(HitByBulletEvent e)
	{
		Direction = -Direction;
	}
 
	public void onHitWall(HitWallEvent e)
	{
		Direction = -Direction;
	}
}
	
