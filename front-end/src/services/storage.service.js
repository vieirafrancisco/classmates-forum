const UserStorageService = {
    getItem(key) {
        return localStorage.getItem(key);
    },
    
    setItem(key, value) {
        localStorage.setItem(key, value);
    },

    deleteSection(){
        localStorage.clear();
    }


}

export default UserStorageService;