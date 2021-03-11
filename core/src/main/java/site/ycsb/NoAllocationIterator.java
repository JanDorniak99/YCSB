/**
 license?
 */

package site.ycsb;

/**
 *  XXX.
 */
public class NoAllocationIterator extends ByteIterator {
  private int bufOff;
  private static byte[] buffer = new byte[100];

  public NoAllocationIterator(long len) {
    this.bufOff = 0;
  }

  public byte nextByte() {
    bufOff++;
    return buffer[0];
  }

  @Override
  public long bytesLeft() {
    return 100 - bufOff;
  }

  @Override
  public void reset() {
  }

  @Override
  public boolean hasNext() {
    return bytesLeft() > 0;
  }

  /** Consumes remaining contents of this object, and returns them as a byte array. */
  public byte[] toArray() {
    return buffer;
  }
}
