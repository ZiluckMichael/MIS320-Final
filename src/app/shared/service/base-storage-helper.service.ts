export abstract class StorageHelperService {
    protected storageRef: Storage;

    clear() {
        this.storageRef.clear();
    }

    getItem<T>(key: string) {
        return JSON.parse(this.storageRef.getItem(key));
    }

    removeItem(key: string) {
        this.storageRef.removeItem(key);
    }

    setItem<T>(key: string, data: T) {
        this.storageRef.setItem(key, JSON.stringify(data));
    }
}