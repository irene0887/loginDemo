package schedule.job.impl;

import schedule.job.JobService;

public class RightJobServiceImpl implements JobService {
	public static boolean rightLight = true;
	
	@Override
	public void process() {
		rightLight = !rightLight;
	}
}
