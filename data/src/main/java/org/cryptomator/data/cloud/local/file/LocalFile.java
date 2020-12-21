package org.cryptomator.data.cloud.local.file;

import org.cryptomator.domain.Cloud;
import org.cryptomator.domain.CloudFile;
import org.cryptomator.util.Optional;

import java.util.Date;

class LocalFile implements CloudFile, LocalNode {

	private final LocalFolder parent;
	private final String name;
	private final String path;
	private final Optional<Long> size;
	private final Optional<Date> modified;

	LocalFile(LocalFolder parent, String name, String path, Optional<Long> size, Optional<Date> modified) {
		this.parent = parent;
		this.name = name;
		this.path = path;
		this.size = size;
		this.modified = modified;
	}

	@Override
	public Cloud getCloud() {
		return parent.getCloud();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public LocalFolder getParent() {
		return parent;
	}

	@Override
	public Optional<Long> getSize() {
		return size;
	}

	@Override
	public Optional<Date> getModified() {
		return modified;
	}
}
