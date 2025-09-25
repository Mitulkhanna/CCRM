# Create a ZIP file containing all the Java source files
import zipfile
import os

# Create a zip file with all the Java source files
zip_filename = "CCRM_Java_Source_Files.zip"

with zipfile.ZipFile(zip_filename, 'w', zipfile.ZIP_DEFLATED) as zipf:
    # Add all files from CCRM_Project directory
    for root, dirs, files in os.walk("CCRM_Project"):
        for file in files:
            if file.endswith(('.java', '.md', '.csv')):
                file_path = os.path.join(root, file)
                # Add to zip with relative path
                arcname = os.path.relpath(file_path, "CCRM_Project")
                zipf.write(file_path, arcname)

print(f"Created {zip_filename} with all Java source files")

# List the contents
with zipfile.ZipFile(zip_filename, 'r') as zipf:
    print("\nContents of the ZIP file:")
    for info in zipf.infolist():
        print(f"  {info.filename}")