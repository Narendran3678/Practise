#!/bin/bash
: '
tarfilename=globalnav-globalfooter-6.6.2.tgz
extractFolder=package
curdir=$(pwd)
web_inf_dir=$curdir/src/main/webapp/WEB-INF

echo "The current directory is: $curdir"
echo "The WEB-INF directory is: $web_inf_dir"
renameNavFile() {
    cd $web_inf_dir/jspFragments/globalnav
    for f in *; do
    mv "$f" "${f%.*}.jsp"
    done
}

renameFooterFile() {
    cd $web_inf_dir/jspFragments/globalfooter
    for f in **/*; do
    mv "$f" "${f%.*}.jsp"
    done
    echo "Renaming .inc to .jsp files completed"
}

copyNavAndFooterFile() {
  rm $web_inf_dir/jspFragments/globalNavAndFooter.jsp
  rm $web_inf_dir/jspFragments/globalNavAndFooterRev.jsp
  rm $web_inf_dir/jspFragments/legacyGlobalNavAndFooter.jsp

  cp -r ./package/compiled/globalfooter $web_inf_dir/jspFragments
  cp -r ./package/compiled/globalNavJSPTemplates $web_inf_dir/jspFragments/globalnav

  sed -e 's/.inc/.jsp/g' ./package/jspFragments/globalNavAndFooter.jsp > $web_inf_dir/jspFragments/globalNavAndFooter.jsp
  sed -e 's/.inc/.jsp/g' ./package/jspFragments/globalNavAndFooterRev.jsp > $web_inf_dir/jspFragments/globalNavAndFooterRev.jsp
  sed -e 's/.inc/.jsp/g' ./package/jspFragments/legacyGlobalNavAndFooter.jsp > $web_inf_dir/jspFragments/legacyGlobalNavAndFooter.jsp
  echo "Copying files to WEB-INF folder completed"
}

removeExtractedPackage() {
  rm -r package
}

deletePackageFolder() {
  if [ -d extractFolder ]
  then
      echo "Directory $extractFolder Exist"
      rm -r package/*
  else
      echo "Directory $extractFolder not Exist"
  fi
}

downloadAndExtractGlobalFooterTar() {
  if [ -e $tarfilename ]
  then
      echo "File $tarfilename Exist"
  else
      echo "File $tarfilename Not Exist"
      echo -e "Your file $tarfilename downloading..."
      wget https://artifacts.apple.com/api/npm/idmsnpm-release-local/@idms/globalnav-globalfooter/-/@idms/globalnav-globalfooter-6.6.2.tgz
  fi
  echo "File $tarfilename Extraction Begin"
  tar -xf globalnav-globalfooter-6.6.2.tgz
  echo "File $tarfilename Extraction Ends"
}

deletePackageFolder
downloadAndExtractGlobalFooterTar
copyNavAndFooterFile
removeExtractedPackage
renameNavFile
renameFooterFile
'