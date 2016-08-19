package schedule.job.impl;

import schedule.job.JobService;

public class LeftJobServiceImpl implements JobService {
	public static boolean leftLight = true;
	
	public void process() {
		leftLight = !leftLight;
	}
}
