package robot.common.sitemap.entity;

public class SiteMapUrl {

	public SiteMapUrl() {
	 
	}
	
	public SiteMapUrl(String loc, String lastmod, String changefreq, Float priority) {
		this.loc = loc;
		this.lastmod = lastmod;
		this.changefreq = changefreq;
		this.priority = priority;
	}
	private String loc;
	private String lastmod;
	private String changefreq;
	private Float priority;
	
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getLastmod() {
		return lastmod;
	}
	public void setLastmod(String lastmod) {
		this.lastmod = lastmod;
	}
	public String getChangefreq() {
		return changefreq;
	}
	public void setChangefreq(String changefreq) {
		this.changefreq = changefreq;
	}
	public Float getPriority() {
		return priority;
	}
	public void setPriority(Float priority) {
		this.priority = priority;
	}
}
