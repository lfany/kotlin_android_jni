import os
import lxml

print('current dir: {}'.format(os.getcwd()))

AndroidManifestPath = os.getcwd() + os.sep + 'app\\src\\main\\AndroidManifest.xml'

print("dest: {}".format(AndroidManifestPath))

# print(open(AndroidManifestPath, 'r').read())
