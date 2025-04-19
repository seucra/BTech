class J105JStaticScope{
    static int classVariable = 10; // Class-level static variable

    public static void main(String[] args) {
        int localVariable = 20; // Method-level local variable
        System.out.println("Local variable: " + localVariable); // Accesses localVariable (20)
        System.out.println("Class variable: " + classVariable); // Accesses classVariable (10)

        {
            int blockVariable = 30; // Block-level variable
            System.out.println("Block variable: " + blockVariable); // Accesses blockVariable (30)
            System.out.println("Class variable in block: " + classVariable); // Still accesses classVariable (10)
        }
        // System.out.println(blockVariable); // Error: blockVariable is out of scope
        instanceMethod();
    }

    static void instanceMethod() {
        int localVariable = 40; // Shadows main's localVariable
        System.out.println("Instance method local variable: " + localVariable); // Accesses localVariable (40)
        System.out.println("Class variable: " + classVariable); // Accesses classVariable (10)
    }
}