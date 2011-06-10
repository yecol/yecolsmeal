package com.qq.cstar.speedymeal.service;

import java.util.ArrayList;

import com.qq.cstar.speedymeal.entity.Merchant;
import com.qq.cstar.speedymeal.dao.MerchantDao;
import com.qq.cstar.speedymeal.entity.Branch;
import com.qq.cstar.speedymeal.entity.Location;

public class ProcessService {

	private MerchantDao merchantDao = new MerchantDao();

	public Branch getBranchByBid(int bid) {
		return merchantDao.getBranchByBid(bid);
	}

	public ArrayList<Branch> getAvailableBranches(Location location) {
		ArrayList<Branch> branches = merchantDao.getAllBranches();

		ArrayList<Branch> result = new ArrayList<Branch>();
		if (branches == null) {
			return result;
		}

		ArrayList<Location> vertexs = null;
		for (Branch branch : branches) {
			vertexs = branch.getBranchDeliveryArea();
			if (vertexs.size() == 1) { // circle
				if (getDistance(branch.getBranchLocation(), location) <= getDistance(
						branch.getBranchLocation(), vertexs.get(0))) {
					result.add(branch);
				}
			} else {
				if (isPointInPolygon(location, vertexs))
					result.add(branch);
			}

		}
		for (Branch b : result) {
			// todo: b
			b.getBranchLocation();
			b.setDistance(0);
			//
			merchantDao.getMenusAndFilled(b);
		}

		return result;
	}

	private double getDistance(Location loc1, Location loc2) {
		double x = loc1.getLatitude() - loc2.getLatitude();
		double y = loc1.getLongitude() - loc2.getLongitude();
		return x * x + y * y;
	}

	private boolean isPointInPolygon(Location location,
			ArrayList<Location> vertexs) {
		double px = location.getLatitude();
		double py = location.getLongitude();

		boolean isInside = false;
		double ESP = 1e-9;
		int count = 0;
		double linePoint1x;
		double linePoint1y;
		double linePoint2x = 180;
		double linePoint2y;

		linePoint1x = px;
		linePoint1y = py;
		linePoint2y = py;

		for (int i = 0; i < vertexs.size() - 1; i++) {
			double cx1 = vertexs.get(i).getLatitude();
			double cy1 = vertexs.get(i).getLongitude();
			double cx2 = vertexs.get(i + 1).getLatitude();
			double cy2 = vertexs.get(i + 1).getLatitude();
			if (isPointOnLine(px, py, cx1, cy1, cx2, cy2)) {
				return true;
			}
			if (Math.abs(cy2 - cy1) < ESP) {
				continue;
			}

			if (isPointOnLine(cx1, cy1, linePoint1x, linePoint1y, linePoint2x,
					linePoint2y)) {
				if (cy1 > cy2)
					count++;
			} else if (isPointOnLine(cx2, cy2, linePoint1x, linePoint1y,
					linePoint2x, linePoint2y)) {
				if (cy2 > cy1)
					count++;
			} else if (isIntersect(cx1, cy1, cx2, cy2, linePoint1x,
					linePoint1y, linePoint2x, linePoint2y)) {
				count++;
			}
		}
		if (count % 2 == 1) {
			isInside = true;
		}

		return isInside;
	}

	private double Multiply(double px0, double py0, double px1, double py1,
			double px2, double py2) {
		return ((px1 - px0) * (py2 - py0) - (px2 - px0) * (py1 - py0));
	}

	private boolean isPointOnLine(double px0, double py0, double px1,
			double py1, double px2, double py2) {
		boolean flag = false;
		double ESP = 1e-9;
		if ((Math.abs(Multiply(px0, py0, px1, py1, px2, py2)) < ESP)
				&& ((px0 - px1) * (px0 - px2) <= 0)
				&& ((py0 - py1) * (py0 - py2) <= 0)) {
			flag = true;
		}
		return flag;
	}

	private boolean isIntersect(double px1, double py1, double px2, double py2,
			double px3, double py3, double px4, double py4) {
		boolean flag = false;
		double d = (px2 - px1) * (py4 - py3) - (py2 - py1) * (px4 - px3);
		if (d != 0) {
			double r = ((py1 - py3) * (px4 - px3) - (px1 - px3) * (py4 - py3))
					/ d;
			double s = ((py1 - py3) * (px2 - px1) - (px1 - px3) * (py2 - py1))
					/ d;
			if ((r >= 0) && (r <= 1) && (s >= 0) && (s <= 1)) {
				flag = true;
			}
		}
		return flag;
	}

	public Branch getBranch(int bid) {
		Branch branch = merchantDao.getBranchByBid(bid);
		merchantDao.getMenusAndFilled(branch);
		System.out.println(branch.toString());
		return branch;

	}

}
