package arrays;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Status {
  int timestamp;
  String message;

  public Status(final int timestamp, final String message) {
    this.timestamp = timestamp;
    this.message = message;
  }

  @Override
  public String toString() {
    return "timestamp=" + timestamp +
        ", message='" + message + '\'';
  }
}

class Receiver {

  List<Status> statusList;
  Iterator<Status> iterator;
  public Receiver() {
    statusList = new ArrayList<>();
    for(int i=1; i<1000; i++) {
      statusList.add(new Status(i, "message" + i));
    }

    statusList.get(5).message = "same";
    statusList.get(14).message = "same";
    statusList.get(18).message = "same";
    iterator = statusList.iterator();
  }

  public Status getNewStatus() {
    if(iterator.hasNext()) {
      return iterator.next();
    }
    return null;
  }
}


/**
 * Mars robot continuously sends Status messages.
 * These can have duplicates in a 10s interval.
 * Filter out the duplicates, and preserve the first message.
 */
public class DuplicateMessagesFiltering {

  Receiver receiver = new Receiver();

  Deque<Status> q = new LinkedList<>();

  public void read() {
    while(true) {
      var newStatus = receiver.getNewStatus();
      if(newStatus == null) {
        continue;
      }
      if(isValid(newStatus)) {
        q.push(newStatus);
      }
      cleanUp();
      System.out.println(q);
    }
  }

  private boolean isValid(Status status) {
    var found = q.stream()
        .filter(s -> s.message.equals(status.message))
        .findFirst();

    return found.isEmpty() || status.timestamp >= found.get().timestamp + 10;
  }

  private void cleanUp() {
    while(!q.isEmpty() &&
        q.peekLast().timestamp < q.peekFirst().timestamp - 10) {
      q.removeLast();
    }
  }

  public static void main(String[] args) {
    DuplicateMessagesFiltering d = new DuplicateMessagesFiltering();
    d.read();
  }
} 