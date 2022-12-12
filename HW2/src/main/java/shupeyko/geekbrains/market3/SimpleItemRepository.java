package shupeyko.geekbrains.market3;

import java.util.List;

public interface SimpleItemRepository {
    List<SimpleItem> getAllItems();
    void addItem(SimpleItem item);
}
