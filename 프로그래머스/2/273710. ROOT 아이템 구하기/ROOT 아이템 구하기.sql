select info.ITEM_ID, info.ITEM_NAME
FROM ITEM_INFO info 
    join ITEM_TREE tree
    on info.ITEM_ID = tree.ITEM_ID
WHERE tree.PARENT_ITEM_ID is null;