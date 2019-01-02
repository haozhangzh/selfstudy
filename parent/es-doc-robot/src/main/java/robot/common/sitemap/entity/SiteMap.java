package robot.common.sitemap.entity;

import java.util.Set;

public class SiteMap {
	
    private String name;
   
    private Set<SiteMapUrl> urlset;
   
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<SiteMapUrl> getUrlset() {
		return urlset;
	}
	public void setUrlset(Set<SiteMapUrl> urlset) {
		this.urlset = urlset;
	}
	
}

