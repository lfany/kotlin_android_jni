str = '''
# GOOGLE SAMPLE PACKAGING DATA
#
# This file is used by Google as part of our samples packaging process.
# End users may safely ignore this file. It has no relevance to other systems.
---
status:       PUBLISHED
technologies: [Android]
categories:   [Input, Android O Preview]
languages:    [Kotlin]
solutions:    [Mobile]
github:       android-AutofillFramework
level:        ADVANCED
icon:         screenshots/icon-web.png
apiRefs:
    - android:android.view.View
    - android:android.service.autofill.AutoFillService
    - android:android.view.autofill.AutoFillManager
license: apache2
'''

import yaml

d = yaml.load(str)
print(d)

dd = yaml.dump(d, default_flow_style=False)
print(dd, type(dd))

import os
from bs4 import BeautifulSoup

file_path = os.path.abspath('.') + os.sep + 'app\\src\\main\\AndroidManifest.xml'
print(file_path)
bs = BeautifulSoup(open(file_path), 'lxml-xml')
print(bs.prettify())

for i in bs.find_all('activity'):
    print(i)
