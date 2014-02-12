/**
 * 
 */
package com.edgaragg.pshop4j.modeling.defaults;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * @author Edgar Gonzalez
 *
 */
class InternalXMLInputStream extends InputStream {

	private ByteBuffer buffer;
	
	/**
	 * 
	 */
	public InternalXMLInputStream(ByteBuffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public int read() throws IOException {
		if (!this.buffer.hasRemaining()) {
            return -1;
        }
        return this.buffer.get() & 0xFF;
	}

	/* (non-Javadoc)
	 * @see java.io.InputStream#read(byte[], int, int)
	 */
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		if (!this.buffer.hasRemaining()) {
            return -1;
        }

        len = Math.min(len, buffer.remaining());
        this.buffer.get(b, off, len);
        return len;
	}

	/* (non-Javadoc)
	 * @see java.io.InputStream#available()
	 */
	@Override
	public int available() throws IOException {
		return this.buffer.remaining();
	}
	
}
